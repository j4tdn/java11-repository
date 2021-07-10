package polymorphism.overriding;

public class ChildPmo extends ParentPmo {
	@Override
	String getItSkills() {
		// super call to parent
		return super.getItSkills();
	}
}