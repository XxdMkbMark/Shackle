#include <bits/stdc++.h>
#include <windows.h>
#include <conio.h>
using namespace std;

struct Block{
	char ch;
	int co=7,cr=0,lo[5],ul[5],tp[5];
	bool glo=0,gul=0,gtp=0;
//	co color 0~15
//	cr ye/no/lo 0/1/2
//	lo a,b,c
//	ul a,b,c
//	tp a,b,x,y
}blo[20][20][25][25];

bool op[20][20][100];
char str[100];

void sc(int fore = 7, int back = 0){
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), (back << 4) + fore);
}
void cs(){
	HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
	COORD coordScreen = { 0, 0 };
	SetConsoleCursorPosition( hConsole, coordScreen );
}
void hc(){
	CONSOLE_CURSOR_INFO cursor_info = { 1, 0 };
	SetConsoleCursorInfo(GetStdHandle(STD_OUTPUT_HANDLE), &cursor_info);
}

void readtxt(int a,int b){
	sprintf(str,"%d-%d.txt",a,b);
	freopen(str,"r",stdin);
	int i,j,t1,t2,t3,t4;
	string s;
	for(i=0;i<21;i++){
		for(j=0;j<21;j++){
			Block tb;
			cin >> s;
			if(s=="/"){
				cin >> s,tb.ch=s[0];
				while(1){
					cin >> s;
					if(s=="/") break;
					else if(s=="co") cin >> t1, tb.co=t1;
					else if(s=="lo") cin >> t1 >> t2 >> t3, tb.lo[0]=t1,tb.lo[1]=t2,tb.lo[2]=t3,tb.glo=1,tb.cr=2;
					else if(s=="ul") cin >> t1 >> t2 >> t3, tb.ul[0]=t1,tb.ul[1]=t2,tb.ul[2]=t3,tb.gul=1;
					else if(s=="ye") tb.cr=0;
					else if(s=="no") tb.cr=1;
					else if(s=="tp") cin >> t1 >> t2 >> t3 >> t4, tb.tp[0]=t1,tb.tp[1]=t2,tb.tp[2]=t3,tb.tp[3]=t4,tb.gtp=1;
				}
			}
			else tb.ch=s[0];
			blo[a][b][i][j]=tb;
		}
	}
	fclose(stdin);
}

int main(){
	
	return 0;
}
