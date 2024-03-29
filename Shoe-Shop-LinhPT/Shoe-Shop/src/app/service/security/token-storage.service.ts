import {Injectable} from '@angular/core';

const TOKEN_KEY = 'Token_key';
const EMAIL_KEY = 'Email_key';
const NAME_KEY = 'Name_key';
const ROLE_KEY = 'Role_key';
const USERNAME_KEY = 'Username_account_key';
const ID_ACCOUNT_KEY = 'Id_Account_key';
const AVATAR_KEY = 'Avatar_key';
const USER_KEY = 'auth-user';
const DAYOFBIRTH = 'Day_of_birth_key'
const IDCARD = 'Card_Id';
const PHONENUMBER_KEY = 'Phonenumber_key'
const ADDRESS_KEY = 'Address_key'
const CART = 'cart_key'
const STORAGE= 'storage_key'

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {
   isLogged = false;
  constructor() {
  }

  getIsLogged() {
    return !!this.getToken();
  }

  logout() {
    window.localStorage.clear();
    window.sessionStorage.clear();
  }

  public clearCart() {
    window.sessionStorage.clear();
  }

  public saveTokenLocal(token: string) {
    window.localStorage.removeItem(TOKEN_KEY);
    window.localStorage.setItem(TOKEN_KEY, token);
  }

  public saveTokenSession(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    if (this.getStorage()== 'local') {
      return localStorage.getItem(TOKEN_KEY) as string;
    } else {
      return sessionStorage.getItem(TOKEN_KEY) as string;
    }
  }
  public setToken(token: string) {
    if (this.getStorage() == 'local') {
      localStorage.removeItem(TOKEN_KEY);
      localStorage.setItem(TOKEN_KEY, token);
    } else {
      sessionStorage.removeItem(TOKEN_KEY);
      sessionStorage.setItem(TOKEN_KEY, token);
    }
  }

  public saveUserLocal(user: any, email: string, idAccount: string, username: string, name: string, roles: string[], avatar: string, idCard: string, phoneNumber: string, address: string, dateOfBirth: string) {
    window.localStorage.removeItem(EMAIL_KEY);
    window.localStorage.removeItem(NAME_KEY);
    window.localStorage.removeItem(ROLE_KEY);
    window.localStorage.removeItem(USERNAME_KEY);
    window.localStorage.removeItem(ID_ACCOUNT_KEY);
    window.localStorage.removeItem(AVATAR_KEY);
    window.localStorage.removeItem(IDCARD);
    window.localStorage.removeItem(PHONENUMBER_KEY);
    window.localStorage.removeItem(ADDRESS_KEY);
    window.localStorage.removeItem(DAYOFBIRTH);
    window.localStorage.setItem(EMAIL_KEY, JSON.stringify(email));
    window.localStorage.setItem(ID_ACCOUNT_KEY, JSON.stringify(idAccount));
    window.localStorage.setItem(USERNAME_KEY, JSON.stringify(username));
    window.localStorage.setItem(NAME_KEY, JSON.stringify(name));
    window.localStorage.setItem(ROLE_KEY, JSON.stringify(roles));
    window.localStorage.setItem(AVATAR_KEY, JSON.stringify(avatar));
    window.localStorage.setItem(IDCARD, JSON.stringify(idCard));
    window.localStorage.setItem(PHONENUMBER_KEY, JSON.stringify(phoneNumber));
    window.localStorage.setItem(ADDRESS_KEY, JSON.stringify(address));
    window.localStorage.setItem(DAYOFBIRTH, JSON.stringify(dateOfBirth));
    window.localStorage.removeItem(USER_KEY);
    window.localStorage.setItem(USER_KEY, JSON.stringify(user));
  }


  public saveUserSession(user: any, email: string, idAccount: string, username: string, name: string, roles: string[], avatar: string, dateOfBirth: string, phoneNumber: string, address: string, idCard: string) {
    window.sessionStorage.removeItem(EMAIL_KEY);
    window.sessionStorage.removeItem(NAME_KEY);
    window.sessionStorage.removeItem(ROLE_KEY);
    window.sessionStorage.removeItem(USERNAME_KEY);
    window.sessionStorage.removeItem(ID_ACCOUNT_KEY);
    window.sessionStorage.removeItem(AVATAR_KEY);
    window.sessionStorage.removeItem(IDCARD);
    window.sessionStorage.removeItem(PHONENUMBER_KEY);
    window.sessionStorage.removeItem(ADDRESS_KEY);
    window.sessionStorage.removeItem(DAYOFBIRTH);
    window.sessionStorage.setItem(EMAIL_KEY, JSON.stringify(email));
    window.sessionStorage.setItem(ID_ACCOUNT_KEY, JSON.stringify(idAccount));
    window.sessionStorage.setItem(USERNAME_KEY, JSON.stringify(username));
    window.sessionStorage.setItem(NAME_KEY, JSON.stringify(name));
    window.sessionStorage.setItem(ROLE_KEY, JSON.stringify(roles));
    window.sessionStorage.setItem(AVATAR_KEY, JSON.stringify(avatar));
    window.sessionStorage.setItem(DAYOFBIRTH, JSON.stringify(dateOfBirth));
    window.sessionStorage.setItem(IDCARD, JSON.stringify(idCard));
    window.sessionStorage.setItem(PHONENUMBER_KEY, JSON.stringify(phoneNumber));
    window.sessionStorage.setItem(ADDRESS_KEY, JSON.stringify(address));
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }


  public getName(): string {
    if (localStorage.getItem(NAME_KEY) != null) {
      return <string>localStorage.getItem(NAME_KEY);
    }
    return <string>sessionStorage.getItem(NAME_KEY);
  }

  public setStorage(storage: string) {
    localStorage.removeItem(STORAGE);
    localStorage.setItem(STORAGE, storage);
    sessionStorage.removeItem(STORAGE);
    sessionStorage.setItem(STORAGE, storage);
  }

  public getStorage() {
    if (localStorage.getItem(STORAGE) == 'local' || sessionStorage.getItem(STORAGE) == 'local') {
      return localStorage.getItem(STORAGE);
    } else {
      return sessionStorage.getItem(STORAGE);
    }
  }

  public getEmail(): string {
    if (localStorage.getItem(EMAIL_KEY) != null) {
      return <string>localStorage.getItem(EMAIL_KEY);
    }
    return <string>sessionStorage.getItem(EMAIL_KEY);
  }

  public getIdAccount(): string {
    if (localStorage.getItem(ID_ACCOUNT_KEY) != null) {
      return <string>localStorage.getItem(ID_ACCOUNT_KEY);
    }
    return <string>sessionStorage.getItem(ID_ACCOUNT_KEY);
  }


  public getUsername(): string {
    if (localStorage.getItem(USERNAME_KEY) != null) {
      return <string>localStorage.getItem(USERNAME_KEY);
    }
    return <string>sessionStorage.getItem(USERNAME_KEY);
  }


  public getUser() {
    let itemString;
    if (localStorage.getItem(USER_KEY) != null) {
      itemString = localStorage.getItem(USER_KEY);
    } else {
      itemString = sessionStorage.getItem(USER_KEY);
    }
    return itemString ? JSON.parse(itemString) : null;
  }


  public getRole(): string[] {
    if (localStorage.getItem(ROLE_KEY) != null) {
      return JSON.parse(<string>localStorage.getItem(ROLE_KEY))
    }
    return JSON.parse(<string>sessionStorage.getItem(ROLE_KEY));
  }






}

