export class DoctorRegistration {
  constructor(
    private doctor_id: number | null,
    public firstName: string,
    public lastName: string,
    public specialist: string,
    public branch: string,
    public photo: string,
    public fee: number) { }

  get id() { return this.doctor_id; }
  set id(newId) { this.doctor_id = newId; }
}

