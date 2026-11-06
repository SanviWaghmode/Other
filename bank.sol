// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BankAccount{
    address public owner;
    uint256 public balance;

    event Deposit(address indexed account , uint256 amount);
    event WithDrawal(address indexed account , uint256 amount);

    constructor(){
        owner = msg.sender;
        balance =0;

    }
    modifier onlyOwner(){
        require(msg.sender == owner , "Only owner can perform this action");
        _;
    }

    //deposit function

    function deposit()public payable {
        require(msg.value>0 , "Deposit numst be greater than zero");
        balance+= msg.value;
        emit Deposit(msg.sender, msg.value);



    }

    //withdrawal function
    function withDraw(uint256 amount) public payable{
        require(amount>0 , "Amount should must be greater than zero");
        require(balance>= amount , "Insuffient funds");
        balance-=amount;

        (bool success , ) = payable(owner).call{value:amount}("");
        require(success , "Trasfer Failed");
        emit WithDrawal(msg.sender, msg.value);

       

    }
     function getBalance() public view returns(uint256){
        return balance;
        
            
        }



}