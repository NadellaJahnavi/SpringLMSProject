package com.Service;

import java.util.List;

import com.entities.UserAddress;

public interface UserAddressService {
	public UserAddress addUserAddress(UserAddress user);
	public UserAddress updateUserAddressDetails(UserAddress user);
	public String  deleteUserAddress(UserAddress address);
	public UserAddress viewAddressByUserId(int addressid);
	public List<UserAddress> viewUserAddressList();
	public UserAddress getPinCode(String pincode);
    public List<UserAddress> getState(String state);
}
