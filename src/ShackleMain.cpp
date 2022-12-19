#include <bits/stdc++.h>
#include <windows.h>
#include <conio.h>
using namespace std;

struct Block{
	char ch;
	int co=7,cr=0,lo[5],ul[5],tp[5];
	
	/*
	co color 0~15
	cr ye/no/lo 0/1/2
	lo a,b,c
	ul a,b,c
	tp a,b,x,y
	*/
	
}blo[20][20][25][25];

bool op[20][20][100];

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

int main(){
	
	return 0;
}
