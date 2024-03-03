import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getProducts } from "../redux/thunk/getProducts";
import { AppDispatch, RootState } from "../redux/store";
import { ProductTypesTs } from "../utils/Product.types";
import "../components/ProductList.css";
import { showSnackbar, hideSnackbar } from "../redux/SnackbarSlice";
import Snackbar from "@material-ui/core/Snackbar";

export function ProductList() {
  const dispatch: AppDispatch = useDispatch();
  const products: ProductTypesTs[] = useSelector(
    (state: RootState) => state.products.productList
  );
  const loading: string = useSelector(
    (state: RootState) => state.products.state
  );

  const snackbarOpen: boolean = useSelector(
    (state: RootState) => state.snackbar.open
  );
  const snackbarMessage: string | null = useSelector(
    (state: RootState) => state.snackbar.message
  );
  const snackbarType: "success" | "error" = useSelector(
    (state: RootState) => state.snackbar.type
  );

  useEffect(() => {
    dispatch(getProducts());
  }, [dispatch]);

  useEffect(() => {
    if (loading === "fulfilled") {
      dispatch(
        showSnackbar({
          message: "Successfully fetched the page",
          type: "success",
        })
      );
    } else {
      dispatch(
        showSnackbar({ message: "Error fetching the page", type: "error" })
      );
    }
  }, [loading, dispatch]);

  if (loading === "pending") {
    return <div className="loader"></div>;
  }

  const handleCloseSnackbar = () => {
    dispatch(hideSnackbar());
  };

  return (
    <div className="product-list">
      <h1 id="main-page-title">
        KDU <span id="marketplace">MARKETPLACE</span>
      </h1>
      <ul id="listing-all-products">
        {products.map((productItem: ProductTypesTs) => (
          <li key={productItem.id} id="product-entity">
            <div className="image-container">
              <img
                src={productItem.image}
                alt="productImage"
                id="productItem"
              ></img>
            </div>
            <div className="entity-descrp">
              <p id="entity-title">{productItem.title}</p>
              <p id="entity-price">$&nbsp;{productItem.price}</p>
            </div>
          </li>
        ))}
      </ul>

      <Snackbar
        open={snackbarOpen}
        autoHideDuration={1000}
        onClose={handleCloseSnackbar}
        message={snackbarMessage}
        ContentProps={{
          style: {
            backgroundColor: snackbarType === "success" ? "green" : "red",
          },
        }}
      />
    </div>
  );
}
