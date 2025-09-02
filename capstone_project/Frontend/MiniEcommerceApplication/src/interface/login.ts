export interface Login {
  id?: number; 
  firstName: string;
  lastName: string;
  emailId: string;
  userId: string;    
  phone?: number;
  passWord: string;
  address: string;
  userType: number;
  isLoggedIn: boolean;
}
