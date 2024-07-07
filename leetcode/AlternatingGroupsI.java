public class AlternatingGroupsI {
  public int numberOfAlternatingGroups(int[] colors) {
    if(colors.length < 3) return 0;
    int count = 0;

    for(int i=0; i < colors.length-2;i++)  {
      if(colors[i] == colors[i+2] && colors[i] != colors[i+1]) {
        count++;
      } 
    }

    // i at colors.length-2
    if(colors[colors.length-2] == colors[0] && colors[colors.length-2] != colors[colors.length-1]) {
      count++;
    }

    // i at colors.length-1
    if(colors[colors.length-1] == colors[1] && colors[colors.length-1] != colors[0]) {
      count++;
    }

    return count;
  }

  public static void main(String[] args) {
    AlternatingGroupsI ag = new AlternatingGroupsI();
    int[] colors = {0,1,0};
    System.out.println( " length "  + ag.numberOfAlternatingGroups(colors));
  }
}
 