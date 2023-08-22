export class Doctor {
  constructor(
    public doctor_id?: string,
    public firstName: string = "",
    public lastName: string ="",
    public email: string = "",
    public password?: string | undefined,
    public specialist: string = "",
    public branch: string = "",
    public photo: string = "",
    public fee: number = 0,
  ) {}
}
