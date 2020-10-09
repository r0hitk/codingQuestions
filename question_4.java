/*
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length, m = nums2.length;
        int size = n + m;
        
        int[] arr = new int[size];
        
        int i = 0, j = 0, k = 0;
        
        while(i < n && j < m){
           if(nums1[i] <= nums2[j]){
                arr[k] = nums1[i];
                i++;
                k++;
            }
            else{
                arr[k] = nums2[j];
                j++;
                k++;
                
            } 
        }
        
        while(i < n){
            arr[k] = nums1[i];
            i++;
            k++;
        }
        
        while(j < m){
            arr[k] = nums2[j];
            j++;
            k++;
        }
        
        double median = 0;
        
        if(((m+n) % 2) == 0){
           double temp = arr[((m+n) / 2) - 1] + arr[(m+n) / 2];
            median = temp/2;
        }
        else{
            median = arr[(m+n) / 2];
        }
        
        return median;
    }
}