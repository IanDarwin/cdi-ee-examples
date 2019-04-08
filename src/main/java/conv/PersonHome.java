package conv;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named @ConversationScoped
public class PersonHome implements Serializable {

	private static final long serialVersionUID = -5790344036048439329L;
	// This will be injected by CDI
	@Inject Conversation conv;
	// @PersistenceContext 
	EntityManager em;
	
	// Will be loaded
	Person instance;
	// For safety
	long oldId = 0;
	
	public String load(long id) {
		instance = daoFind(id);
		if (conv.isTransient()) {
			conv.begin();
			System.out.println("PersonHome.load(): conversation started");
		}
		this.oldId = id; 			// save for a rainy day
		return "PersonEdit?faces-redirect=true";
	}
	
	public String update() {
		if (instance.id != oldId) {
			throw new SecurityException();
		}
		if (em != null) {
			// In this quick demo we don't have an EM
			em.merge(instance);
		}
		if (!conv.isTransient()) {
			conv.end();
			System.out.println("PersonHome.update(): conversation ended");
		}
		return "PersonList?faces-redirect=true";
	}

	/* So we don't have to do a full JPA setup here */
	private Person daoFind(long id) {
		if (id == 42) {
			return new Person(42, "Robin", "Williams");
		}
		throw new IllegalArgumentException("Could not find Person#" + id);
	}

	public Person getInstance() {
		return instance;
	}

	public void setInstance(Person instance) {
		this.instance = instance;
	}
}
