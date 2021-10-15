package com.neosoft.lab4;

import com.neosoft.lab3.Room;

class House 
{ 
Room r; 
void createHouse() 
{ 
r = new Room(); 
} 
void displayHouse() 
{ 
r.getData(); 
} 
public static void main (String args[]) 
{ 
House h = new House(); 
h.createHouse(); 
h.displayHouse(); 
} 
}
