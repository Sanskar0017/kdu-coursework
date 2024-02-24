import { useContext } from "react";
import { ProductContext } from "../../App";
import { useParams, Link } from "react-router-dom";
import "../productdetails/ProductDetail.css";

export const ProductDetail = () => {
  const { products } = useContext(ProductContext);
  const { id } = useParams();

  if (!id) {
    return <div>No Match Found</div>;
  }

  const findProduct = products.find(
    (productItem) => productItem.id === parseInt(id)
  );

  return (
    <div className="product-detail-container">
      <div className="product-search-header">
        <input type="text" placeholder="Search.." id="search-input"></input>
        <button id="search-btn">X</button>
      </div>

      <div className="static-container">{findProduct?.title}</div>
      <div className="product-details">
        <div className="product-image">
          <img
            src={findProduct?.image}
            alt="Product-profile-pic"
            id="product-profile-image"
          ></img>
        </div>
        <div className="product-description">
          <h1 className="product-model">Model:&nbsp;{findProduct?.title}</h1>
          <h2 className="product-madeby">
            MADE BY:&nbsp;{findProduct?.title.split(" ")[0]}{" "}
          </h2>
          <div className="product-price">
            Price:&nbsp;$&nbsp;{findProduct?.price}{" "}
          </div>
          <h6 className="product-desc">
            Product Description:&nbsp;<br></br>
            <div id="product-detail-desc">{findProduct?.description}.</div>
          </h6>
          <Link to="/">
            <button type="submit" id="back-to-products">
              Back To Products
            </button>
          </Link>
        </div>
      </div>
    </div>
  );
};
