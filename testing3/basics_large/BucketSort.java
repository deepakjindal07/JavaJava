package basics_large;
import java.util.Collections;
import java.util.Vector;

class Main
{
    public static void main (String[] args)
    {
        int arr[] = { 30,40,10,80,5,12,70 };
        int n = arr.length; int k=4;
        bucketSort(arr, n, k);

        for (int i = 0; i < n; i++) {
			System.out.print( arr[i] + " ");
		}

    }

    static void bucketSort(int arr[], int n, int k) {

        int max_val=arr[0];
        for(int i=1;i<n;i++) {
			max_val=Math.max(max_val,arr[i]);
		}
        max_val++;

        @SuppressWarnings("unchecked")
        Vector<Integer>[] buckets = new Vector[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector<>();
        }

        for (int i = 0; i < n; i++) {
            int idx = (arr[i] * k)/max_val;
            buckets[idx].add(arr[i]);
        }

        for (int i = 0; i < k; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < k; i++) {
            for (Integer element : buckets[i]) {
                arr[index++] = element;
            }
        }
    }
}
