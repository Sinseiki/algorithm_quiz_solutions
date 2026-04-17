#include<iostream>
int main(){
    int m,n;
    std::cin >> m >> n;

    int a[n];
    std::fill(a, a+n, 1);
    for(int i = 2; i <= n/i; i++){
        if(a[i - 1] == 1){
            for(int j = i; j <= n/i; j++){
               a[i * j - 1] = 0;
            }
        }
    }
    for(int i = m - 1 > 1 ? m - 1 : 1; i < n; i++){
        if(a[i]) std::cout << i + 1 << "\n";
    }
}