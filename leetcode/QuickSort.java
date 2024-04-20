public class Quicksort {
  void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp; 
  }

  int partition(int[] arr, int low, int high) {
      int pivot = arr[high];
    int i = low-1 ;
    for(int j = low; j < high ; j++ ) {
      if(arr[j] < pivot) {
        i++;
        swap(arr,i,j);
      }
    }

    swap(arr,i+1,high);

    return (i+1);
  }

  void quickSort(int[] arr, int low, int high) {
    if(low<high) {
       // pi is partitioning index, arr[p]
        // is now at right place
        int pi = partition(arr, low, high);

        // Separately sort elements before
        // partition and after partition
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high); 
    }
  }

  public static void main(String[] args) {
    Quicksort qs = new Quicksort();
    int[] arr = {10, 7, 8, 9, 1, 5};
    qs.quickSort(arr,0,arr.length-1);
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
