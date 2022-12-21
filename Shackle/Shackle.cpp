#include <bits/stdc++.h>
#include <windows.h>
#include <conio.h>
using namespace std;

struct Block{
	char character;
	int color=7,interactive=0,locked[5],unlock[5],transport[5];
	bool inr_locked=0,inr_unlock=0,inr_transport=0;
//	co color 0~15
//	cr ye/no/lo 0/1/2
//	lo a,b,c
//	ul a,b,c
//	tp a,b,x,y
}blo[20][20][25][25];

bool opened[20][20][100];
char str[100];

void sc(int fore = 7, int back = 0){ //setcolor
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), (back << 4) + fore);
}
void cs(){ //clearscreen
	HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
	COORD coordScreen = { 0, 0 };
	SetConsoleCursorPosition( hConsole, coordScreen );
}
void hc(){ //hidecursor
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
			cin>>s;
			if(s=="/"){
				cin>>s,tb.character=s[0];
				while(1){
					cin>>s;
					if(s=="/") break;
					else if(s=="co") cin>>t1,tb.color=t1;
					else if(s=="lo") cin>>t1>>t2>>t3,tb.locked[0]=t1,tb.locked[1]=t2,tb.locked[2]=t3,tb.inr_locked=1,tb.interactive=2;
					else if(s=="ul") cin>>t1>>t2>>t3,tb.unlock[0]=t1,tb.unlock[1]=t2,tb.unlock[2]=t3,tb.inr_unlock=1;
					else if(s=="ye") tb.interactive=0;
					else if(s=="no") tb.interactive=1;
					else if(s=="tp") cin>>t1>>t2>>t3>>t4,tb.transport[0]=t1,tb.transport[1]=t2,tb.transport[2]=t3,tb.transport[3]=t4,tb.inr_transport=1;
					// get the code in txt
				}
			}
			else tb.character=s[0];
			blo[a][b][i][j]=tb;
		}
	}
	fclose(stdin);
}

int main(){
	
	return 0;
}
