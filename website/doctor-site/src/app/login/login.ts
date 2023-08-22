export class Login {
  id: number | undefined;
  userId: string = "DEFAULT";
  username: string | undefined;
  password: string | undefined;
  role: string = "unlogged";
  loggedIn: boolean = false;
}
