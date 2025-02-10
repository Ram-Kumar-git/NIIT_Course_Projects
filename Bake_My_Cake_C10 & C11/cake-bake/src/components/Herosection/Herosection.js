import React, { useState, useEffect } from "react";
import axios from "axios";
import { Grid, Typography, Button, Card, CardMedia, CardContent } from "@mui/material";
import { useNavigate } from "react-router-dom";

const HeroSection = ({ categoryFilter }) => {
  const [items, setItems] = useState([]);
  const navigate = useNavigate();

  // Fetch data from json-server
  useEffect(() => {
    axios
      .get("http://localhost:3001/cakes") // Ensure this matches your API
      .then((response) => setItems(response.data))
      .catch((error) => console.error("Error fetching data:", error));
  }, [categoryFilter]); // Only re-fetch items when categoryFilter changes

  const scrollToImages = () => { 
    const section = document.getElementById("images-section");
    if (section) {
      section.scrollIntoView({ behavior: "smooth" });
    }
  };// used for shop now button

  const scrollToForm = () => {
    const formSection = document.getElementById("order-form");
    if (formSection) {
      formSection.scrollIntoView({ behavior: "smooth" });
    } else {
      console.error("Form section not found!");
    }
  };

  const handleImageClick = (id) => {
    navigate(`/order/${id}`);
    scrollToForm();
  };

  // Filter items by category
  const filteredItems = items.filter((item) => {
    return (
      categoryFilter === "" ||
      item.category.toLowerCase().trim() === categoryFilter.toLowerCase().trim()
    );
  });

  return (
    <section className="hero">
      <div className="hero-header">
        <Grid container spacing={2} alignItems="center" sx={{ padding: "16px" }}>
          <Grid item xs={12} md={6}>
            <Typography variant="h3" component="h1" gutterBottom>
              Birthday Cake Delivery
            </Typography>
            <Typography variant="h5" component="h3" color="text.secondary" gutterBottom>
              Same Day and Midnight Delivery
            </Typography>
            <Button
              variant="outlined"
              color="goldenrod"
              onClick={scrollToImages}
              sx={{ marginTop: "16px", width: "25%",
                fontSize: "25px",
                color:"#844414",
                borderRadius:"30px"
               }}
            >
              Shop Now
            </Button>
          </Grid>
          <Grid item xs={12} md={6}>
            <img src="../cakes/Classic Cheesecake.jpg" alt="Classic Cheesecake" style={{ width: "100%" }} />
          </Grid>
        </Grid>
      </div>

      <div id="images-section" className="hero-container">
        <Grid container spacing={4} sx={{ padding: "16px" }}>
          {filteredItems.map((item) => (
            <Grid item xs={12} sm={6} md={3} key={item.id}>
              <Card
                sx={{
                  cursor: "pointer",
                  objectFit: "cover",
                  height: "100%",
                  backgroundColor: "#EEEADE",
                }}
                onClick={() => handleImageClick(item.id)}
              >
                <CardMedia
                  component="img"
                  image={item.image}
                  alt={item.name}
                  sx={{ height: 200, objectFit: "fill" }}
                />
                <CardContent>
                  <Typography variant="h6" component="div">
                    {item.name}
                  </Typography>
                  {/* <Typography variant="body2" color="text.secondary">
                    {item.description}
                  </Typography> */}
                  <Typography variant="body1" sx={{ fontWeight: "bold" }}>
                    ₹{item.price}
                  </Typography>
                </CardContent>
              </Card>
            </Grid>
          ))}
        </Grid>
      </div>
      <hr />
    </section>
  );
};

export default HeroSection;