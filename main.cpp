#include<iostream>
#include<map>
#include <random>
#include <vector>

class chain {
private:
	bool WordCounter = 0;
	std::map < std::string, std::map < std::string , int >> dic;
public:
	void feed_me()
	{
	    if (!WordCounter)
			   std::cout << "WARNING : there should be at least ONE word.\n";

		std::cout << "Write -1 when you finish.\n";
		std::string temp;
		if (WordCounter == 0) {
			std::cin >> temp;
			WordCounter = 1;
		}
		while (true)
		{
			std::string s;
			std::cin >> s;
			if (s == "-1")
				   break;
			dic[temp][s]++;
			temp = s;
		}
		std::cout << "that is enough.\n";
	}
	void generate()
	{
		std::cout << "give me the tip.\n";
 		std::string s;
		while (true) {
			std::cin >> s;
			if (dic[s].size() == 0)
			{
				std::cout << "the tip does not exist, try again.\n";
			}
			else break;
		}
		std::vector<std::string>words;
		std::vector<int>weight;
		int t;
		std::cout << "give the number of words that you want to generate.\n";
		std::cin >> t;
		while (t--) {
		  auto it = dic[s];
		  for (auto x = it.begin(); x != it.end(); x++)
		  {
			  words.push_back(x->first);
		  	  weight.push_back(x->second);

		  }
		    std::discrete_distribution<int>distribution(weight.begin(),weight.end());

			std::default_random_engine Random;
			s = words[distribution(Random)];
			std::cout<<s<<" ";
			weight.clear();
			words.clear();
		}
	}
};

int main(){
	chain test;
	test.feed_me();
	test.generate();
	return 0;
}
