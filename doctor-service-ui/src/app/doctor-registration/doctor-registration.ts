export class DoctorRegistration {
  constructor(
    public doctor_id: number | null = null,
    public firstName: string = "",
    public lastName: string = "",
    public specialist: string = "",
    public branch: string = "",
    public photo: string = "",
    public fee: number = 0) { }
}

