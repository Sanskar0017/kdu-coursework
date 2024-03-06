export interface RoomType {
    id: string;
    name: string;
    price: number;
    addOns: AddOn[];
  }
  
  export interface RoomDetails {
    roomTypes: RoomType[];
  }
  
  export interface BookingState {
    roomTypes: RoomType[];
    selectedRoomId: string;
  }

  export interface AddOn {
    name:     string;
    cost:     string;
    currency: Currency;
  }

  export enum Currency {
    Inr = "INR",
  }
  
  