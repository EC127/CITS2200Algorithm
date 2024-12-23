// Jesse Yang (23307563), Qichong Huang (23311085)

/**
 * An implementation of the Shallows problem from the 2022 CITS2200 Project
 */
public class ShallowsImpl implements Shallows {
  /**
   * {@inheritdoc}
   */
  public int[] maximumDraughts(int ports, Lane[] lanes, int origin) {
    // TODO: Implement your solution
    int i;
    int [] results = new int[ports];    //initlialize the results array
    for(i=0;i<ports;i++){
      results[i]=0;
    }
    int j;
    int temp = 0;
    int count = 0;
    for(i=0;i<lanes.length;i++){
      if(lanes[i].depart==origin){
        results[lanes[i].arrive]=lanes[i].depth;
        count++;
      }
    }

    int k = 0;
  while(k<ports-count){
    for(i=0;i<ports;i++){
      if(i == origin){
        results[i] = Integer.MAX_VALUE;
        continue;
      }
      if(results[i]==0)
      continue;
      for(j=0;j<lanes.length;j++){
        if(lanes[j].depart==i){
          if(results[i]<lanes[j].depth && results[i]!=0)
          temp = results[i];
          else
          temp = lanes[j].depth;
          if(temp>results[lanes[j].arrive])
          results[lanes[j].arrive]=temp;
        }
      }
    }
    k++;
  }
    return results;
  }
}