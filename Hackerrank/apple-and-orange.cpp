#include <iostream>

using namespace std;

int s,t,a,b,m,n,as,os,d;

bool fall(int x) {
    return x >= s && x <= t;
}

void count(int& fruits, int& tree, int& sf) {
    while(fruits--) {
        cin>>d;
        sf += fall(tree + d) ? 1 : 0;
    }
}

int main() {
    cin>>s>>t>>a>>b>>m>>n;
    as = os = 0;
    count(m, a, as);
    count(n, b, os);
    cout<<as<<"\n";
    cout<<os<<"\n";
    return 0;
}