package encapsulation.inside;

//parent class
public class Developer {

//	String getSkills() { // neu la default thi lop con Freelancer ko goi duoc
//		return "JAVA";
//}
	protected String getSkills() { // vi la protected nen lop con Freelancer goi duoc
		return "JAVA";
	}
}
