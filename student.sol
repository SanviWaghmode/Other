
 // SPDX-License-Identifier: MIT
 pragma solidity ^0.8.0;

 contract StudentData {

     struct Student {
         string name;
         string className;
         uint256 age;
         uint256 rollNo;
     }

     Student[] public students;
     address public owner;

     constructor() {
         owner = msg.sender;
     }

     modifier onlyOwner() {
         require(msg.sender == owner, "Only owner can add students");
         _;
     }

     function addStudent(
         string memory _name,
         string memory _className,
         uint256 _age,
         uint256 _rollNo
     ) public onlyOwner {

         require(bytes(_name).length > 0, "Invalid name");
         require(_age > 0 && _age <= 150, "Invalid age");

         students.push(Student(_name, _className, _age, _rollNo));
     }

     function getTotalStudents() public view returns (uint256) {
         return students.length;
     }

     function getStudent(uint256 index)
         public view
         returns (string memory, string memory, uint256, uint256)
     {
         require(index < students.length, "Invalid index");

         Student memory s = students[index];

         return (s.name, s.className, s.age, s.rollNo);
     }
 }
