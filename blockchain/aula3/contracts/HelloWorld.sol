pragma solidity ^0.8.13;

contract HelloWorld {
    uint public myNumber = 0;

    function setInt(uint _newNumber) public {
        myNumber = _newNumber;
    }
}