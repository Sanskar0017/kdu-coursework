export interface IListItem {
  id: number;
  text: string;
}

export interface IThemeContext {
  list: IListItem[];
  searchQuery: string;
  handleSearch: (query: string) => void;
  handleAddItem: (text: string) => void;
  handleDeleteItem: (id: number) => void;
}

export interface ThemeProviderProps {
  children: React.ReactNode;
}
