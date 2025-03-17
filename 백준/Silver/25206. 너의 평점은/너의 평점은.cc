#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stdio.h>
#include <string>
#include <cstring>



using namespace std;



int main()
{
	string subject;
	char *grade;
	float credit, gradeInt, sum, creditSum;

	sum = 0;
	creditSum = 0;
	grade = new char[3];


	for (int i = 0; i < 20; i++) {
		subject = "";
		credit = 0;
		memset(grade, 0, sizeof(char) * 3);

		cin >> subject >> credit >> grade;

		if ((*grade == 'A') && (*(grade + 1) == '+')) {
			gradeInt = 4.5;
		}
		else if ((*grade == 'A') && (*(grade + 1) == '0')) {
			gradeInt = 4.0; 
		}
		else if ((*grade == 'B') && (*(grade + 1) == '+')) {
			gradeInt = 3.5; 
		}
		else if ((*grade == 'B') && (*(grade + 1) == '0')) {
			gradeInt = 3.0; 
		}
		else if ((*grade == 'C') && (*(grade + 1) == '+')) {
			gradeInt = 2.5; 
		}
		else if ((*grade == 'C') && (*(grade + 1) == '0')) {
			gradeInt = 2.0; 
		}
		else if ((*grade == 'D') && (*(grade + 1) == '+')) {
			gradeInt = 1.5; 
		}
		else if ((*grade == 'D') && (*(grade + 1) == '0')) {
			gradeInt = 1.0;
		}
		else { 
			gradeInt = 0; 
		}

		if (*grade == 'P') {
			continue; 
		}
		sum = sum + credit * gradeInt;
		creditSum = creditSum + credit;
	}

	cout << sum/creditSum << endl;

	delete [] grade;

	return 0;
}