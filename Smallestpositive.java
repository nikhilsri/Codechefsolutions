long smallestpositive(long[] array, int n){ 
        // Your code goes here 
        long ans=1L;
        Arrays.sort(array);
        for(int i=0;i<n && array[i]<=ans;i++){
            ans=ans+array[i];
        }
        return ans;
}
