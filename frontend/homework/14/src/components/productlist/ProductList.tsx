import { ProductContext } from "../../App";
import { useContext, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { ProductTypesTs } from "../../utils/products.types";
import "../productlist/productlist.css";

export const ProductList = () => {
  const { products, searchTerm, setSearchTerm } = useContext(ProductContext);
  const [filteredProducts, setFilteredProducts] =
    useState<ProductTypesTs[]>(products);
  const [selectedCategory, setSelectedCategory] = useState<string>("All");
  const [isFiltering, setIsFiltering] = useState(false);
  const [sortTerm, setSortTerm] = useState<string>("Price");

  useEffect(() => {
    let Data = [...products];

    if (isFiltering) {
      console.log(searchTerm);
      Data = Data.filter((productItem: ProductTypesTs) => {
        return productItem.title
          .toLowerCase()
          .includes(searchTerm.toLowerCase());
      });
    }

    if (selectedCategory !== "All") {
      Data = Data.filter((productItem: ProductTypesTs) => {
        return (
          productItem.category.toLowerCase() === selectedCategory.toLowerCase()
        );
      });
    }

    if (sortTerm === "asc") {
      Data.sort((a, b) => a.price - b.price);
    } else if (sortTerm === "desc") {
      Data.sort((a, b) => b.price - a.price);
    }

    setFilteredProducts(Data);
  }, [products, searchTerm, selectedCategory, isFiltering, sortTerm]);

  const handleProductSearch = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSearchTerm(event.target.value);
  };

  const handleCategoryChange = (
    event: React.ChangeEvent<HTMLSelectElement>
  ) => {
    setSelectedCategory(event.target.value);
  };

  const handSearchClick = () => {
    setIsFiltering(true);
  };

  const handleSortChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    setSortTerm(event?.target.value);
  };

  return (
    <div className="productlisting">
      <div className="product-header">
        <div className="product-listpage-header">
          <input
            type="text"
            placeholder="Search.."
            value={searchTerm}
            id="search-input"
            onChange={handleProductSearch}
          ></input>
          <button id="search-btn" onClick={handSearchClick}>
            X
          </button>
        </div>

        <div className="product-filter">
          <select
            id="filter-product"
            value={selectedCategory}
            onChange={handleCategoryChange}
          >
            <option value="All">All Categories</option>
            <option value="Electronics">Electronics</option>
            <option value="Jewelery">Jewelery</option>
            <option value="Men's Clothing">Men's Clothing</option>
            <option value="Women's Clothing">Women's Clothing</option>
          </select>
        </div>

        <div className="product-sort">
          <select id="price-btn" value={sortTerm} onChange={handleSortChange}>
            <option value="Price">Price</option>
            <option value="asc">ASC</option>
            <option value="desc">DESC</option>
          </select>
        </div>
      </div>

      <h1 id="main-page-title">
        KDU <span id="marketplace">MARKETPLACE</span>
      </h1>
      <ul id="listing-all-products">
        {filteredProducts.map((productItem: ProductTypesTs) => (
          <li key={productItem.id} id="product-entity">
            <Link to={`/product/${productItem.id}`}>
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
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
};
