// SPDX-License-Identifier: MIT
pragma solidity ^0.8.13;

contract Base {

    string public name;

    function changeName(string memory _name) public {
        name = _name;
    }
}