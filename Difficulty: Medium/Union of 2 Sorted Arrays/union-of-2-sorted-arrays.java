class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;
      ArrayList<Integer>  result = new ArrayList<>();
         int i = 0;
         int j = 0;
          while (i < n1 && j < n2) {
              if ( a[i] <= b[j]) {
                   if (result.size() == 0 || result.get(result.size()-1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
            } 
            else {
                if (result.size() == 0 || result.get(result.size()-1) != b[j]) {
                    result.add(b[j]);
                }
                j++;
            }
        }
        while (i < n1) {
            if (result.size() == 0 || result.get(result.size()-1) != a[i]) {
                result.add(a[i]);
            }
            i++;
        }
         while (j < n2) {
            if (result.size() == 0 || result.get(result.size()-1) != b[j]) {
                result.add(b[j]);
            }
            j++;
        }
        return result;
    }
}
             
