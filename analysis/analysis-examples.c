void bubbleSort(int array[], int n)
{
  int i, j;

  for (i = n; i > 1; i--) 
    {

      for (j = 1; j < i; j++)
        {

          if (array[j] < array[j-1])
            {

              int temp = array[j];

              array[j] = array[j-1];

              array[j-1] = temp;

            }
        }
    }
}


int sum(int array[], int n) 
{
  int sum = 0;
  
  for (int i = 0; i < n; i++)
    
    sum += array[i];
  
  return sum;
  
}   



void multTable(int array[], int n) 
{
  
  for (int i = 0; i < n; i++) {
    
    for (int j = 0; j < n; j++)
      
      printf("%d\t", array[i] * array[j]);
    
    printf("\n");
    
  }
  
}  


void selectionSort(int array[], int n)
{

  int i, j;

  for (i = 0; i < n; i++)     
   {

      int min = array[i];

      int minPos = i;

      for (j = i + 1; j < n; j++) 
        {

          if (min > array[j]) 
            {

              min = array[j];

              minPos = j;

            }
        }
      array[minPos] = array[i];

      array[i] = min;
    }
}


void bubbleSort(int array[], int n)
{
  int i;
  
  int changed = 1;

  while (changed) 
    {

      changed = 0;

      for (i = 1; i < n; i++)
        {

          if (array[i] < array[i-1])
            {

              changed = 1;

              int temp = array[i];

              array[i] = array[i-1];

              array[i-1] = temp;
            }
        }
}


void insertionSort(int array[], int n)
{

  int i, j;

  for (i = 1; i < n; i++) 
    {

      j = i

      while (j  > 0 && array[j] < array[j-1]) 
        {

          int temp = array[j];

          array[j] = array[j-1];

          array[j-1] = temp;

          j--
        }
}
