// Jesse Yang (23307563), Qichong Huang (23311085)

/**
 * An implementation of the Fines problem from the 2022 CITS2200 Project
 */
public class FinesImpl implements Fines {
  /**
   * {@inheritdoc}
   */
    
    /**
     * 
     * @param priorities
     * @return 
     */
    private long count;
    
  public long countFines(int[] priorities) {
    // TODO: Implement your solution
    int z=0;
    int diffnum = 0;
    while(z<priorities.length){
        if(priorities[0]!=priorities[z])
        diffnum++;
        z++;
    }
    if(diffnum!=0)
    mergeSort(priorities, 0, priorities.length - 1);
    return count;
    }
        
    private void merge(int[] a, int p, int q, int r)
	{
            int n1=q-p+1;
            int n2=r-q;
            int[] L=new int[n1];
            int[] R=new int[n2];
            int i,j;
            for(i=0;i<n1;i++){
                L[i]=a[p+i];
            }
            for(j=0;j<n2;j++){
                R[j]=a[q+j+1];
            }
            i=0;
            j=0;
            int k=p;
            while(i<n1&&j<n2){
                if(L[i]>R[j]){
                    a[k++]=L[i++];
                }
                else{
                    if(L[i]<R[j])
                    count=count + n1-i ;
                    if(L[i]==R[j])
                    count = count + n1 -i -1;
                    a[k++]=R[j++];
                    
                }
            }
            while(i<n1){
                a[k++]=L[i++];
                
                
            }
            while(j<n2){
                a[k++]=R[j++];
                
            }
	}
    
    private void mergeSort(int[] a, int p, int r)
	{
            if(p<r){
                int q=(int)Math.floor((p+r)/2);
                mergeSort(a,p,q);
                mergeSort(a,q+1,r);
                merge(a,p,q,r);
            }
	}
}
    