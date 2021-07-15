
public class ObjectSort {
	private String id;
    private String name;
    private String age;

    public ObjectSort() {
    }

    public ObjectSort(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    public int compare(ObjectSort sort){
        if(getName().compareTo(sort.getName()) > 0){
            return 1;
        }
        if (getName().compareTo(sort.getName()) == 0) {
            return getName().compareTo(sort.getName());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ObjectSort{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }

}
