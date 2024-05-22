//  SPDX-License-Identifier: MIT
pragma solidity ^0.8.13;

import './Base.sol';

contract Creator {

    address public mainAddress;

    function CreateBase() public {
        Base newBase = new Base();
        mainAddress = address(newBase);
    }
}