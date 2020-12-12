export class User {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  role: string;
  username: string;
  password: string;
  enabled: boolean;

  constructor(id?: number, firstName?: string, lastName?: string, email?: string,
    role?: string, username?: string, password?: string, enabled?: boolean){
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.role = role;
      this.username = username;
      this.password = password;
      this.enabled = enabled;
  }
}
