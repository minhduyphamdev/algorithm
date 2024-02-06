public class AnonymousObject {
  abstract class God {
    protected String test;
    abstract String killSomeone(String name);
  }

  public static void main(String[] args) {
    God god = new AnonymousObject().new God() {
      @Override
      String killSomeone(String name) {
        this.test = name;
        return name;
      }
    };

    String name = god.killSomeone("minh");
    System.out.println(name);
    System.out.println(god.test);
  }
  
}
 