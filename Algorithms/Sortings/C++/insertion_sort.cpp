#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

void insertion_sort(vector<int>& arr)
{
    for (int i = 1; i < arr.size(); ++i)
    {
        int cur = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > cur)
        {
            arr[j + 1] = arr[j];
            --j;
        }
        arr[j + 1] = cur;
    }
}