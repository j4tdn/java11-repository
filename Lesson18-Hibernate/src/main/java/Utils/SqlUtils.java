package Utils;

import java.util.List;

public class SqlUtils {
    private SqlUtils()
    {

    }
    public  static <Element> void print(List<Element> list)
    {
        for(Element element: list)
        {
            System.out.println(element);
        }
    }
    public  static  void breakline()
    {
        System.out.println("=============================");
    }
}
