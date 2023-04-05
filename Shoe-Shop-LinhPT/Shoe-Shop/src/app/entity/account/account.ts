import {AccountRole} from "./account-role";

export interface Account {
  accountId?: number;
  userName?: string;
  password?: string;
  accountRoleList?: AccountRole[];
  email?: string;
  name?: string;
  idCard?: string;
  address?: string;
  phoneNumber?: string;
  dateOfBirth?: string;
  avatar?: string;
}
