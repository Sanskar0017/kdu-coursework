import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import {
  createContext,
  useEffect,
  useState,
  useMemo,
  Dispatch,
  SetStateAction,
} from "react";
import { ProductTypesTs } from "./utils/products.types";
import { ProductList } from "./components/productlist/ProductList";
import { ProductDetail } from "./components/productdetails/ProductDetail";

interface ProductProps {
  products: ProductTypesTs[];
  setProducts: Dispatch<SetStateAction<ProductTypesTs[]>>;
  searchTerm: string;
  setSearchTerm: Dispatch<SetStateAction<string>>;
  filterBy: string;
  setFilterBy: Dispatch<SetStateAction<string>>;
  sortBy: string;
  setSortBy: Dispatch<SetStateAction<string>>;
}

export const ProductContext = createContext<ProductProps>({
  products: [],
  setProducts: () => {},
  searchTerm: "",
  setSearchTerm: () => {},
  filterBy: "",
  setFilterBy: () => {},
  sortBy: "",
  setSortBy: () => {},
});

interface ProductContextProps {
  children: React.ReactNode;
}

export const ProductProvider = ({ children }: ProductContextProps) => {
  const [products, setProducts] = useState<ProductTypesTs[]>([]);
  const [searchTerm, setSearchTerm] = useState<string>("");
  const [filterBy, setFilterBy] = useState<string>("");
  const [sortBy, setSortBy] = useState<string>("");

  useEffect(() => {
    const fetchData = async () => {
      const response = await fetch("https://fakestoreapi.com/products");
      if (!response.ok) {
        console.log("Error fetching from API");
      }

      const data = await response.json();
      setProducts(data);
    };

    fetchData();
  }, []);

  const ProductcontextValue = useMemo(
    () => ({
      products,
      setProducts,
      searchTerm,
      setSearchTerm,
      filterBy,
      setFilterBy,
      sortBy,
      setSortBy,
    }),
    [products, searchTerm, filterBy, sortBy]
  );

  return (
    <ProductContext.Provider value={ProductcontextValue}>
      {children}
    </ProductContext.Provider>
  );
};

function App() {
  return (
    <ProductProvider>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<ProductList />} />
          <Route path="/product/:id" element={<ProductDetail />} />
        </Routes>
      </BrowserRouter>
    </ProductProvider>
  );
}

export default App;
