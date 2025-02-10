import React, { useState, useEffect } from "react";
import { useForm, Controller } from "react-hook-form"; //controller for link between react-hook-form and material-ui
import {
  TextField,
  MenuItem,
  Button,
  Snackbar,
  Alert,
  Card,
  Grid,
  CardMedia,
  Typography,
  CardContent,
} from "@mui/material";
import styled from "styled-components";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";
 
// Styled container for the form
const FormContainer = styled.div`
  margin: 2rem auto;
  max-width: 1400px;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
  background: #edc9af;
 
  @media (max-width: 600px) {
    padding: 1rem;
  }
`;
 
const FormHeader = styled.h2`
  text-align: center;
  margin-bottom: 1rem;
  font-size: 15px;
  font-family: italic;
`;
 
const weights = ["2kg", "1kg", "500gm", "250gm", "6 pieces", "4 pieces"];
 
const OrderForm = () => {
  const [selectedItem, setSelectedItem] = useState(null); //Stores details of the selected item fetched via API.
  const [successMessage, setSuccessMessage] = useState("");
  const { id } = useParams();
  const navigate = useNavigate();
 
  const {
    control,
    handleSubmit,
    reset,
    formState: { errors, isValid }, //Tracks form validation and errors.
  } = useForm({
    mode: "onChange", // This enables the validation as you type
  });
 
  useEffect(() => {
    // Fetch item details based on the ID from the URL
    axios.get(`http://localhost:3001/cakes/${id}`).then((response) => {
      console.log(response.data); // Check if data contains image field
      setSelectedItem(response.data);
    });
  }, [id]);
 
  const onSubmit = async (data) => {
    try {
      // Add item details to the order data
      const orderData = { ...data, item: selectedItem };
      // Send POST request to json-server
      await axios.post("http://localhost:3001/orders", orderData);
      // Show success message
      setSuccessMessage("Order placed successfully!");
      // Redirect after a delay
      setTimeout(() => {
        setSuccessMessage("");
        navigate("/home"); // Navigate to home view after successful order
      }, 1000);
    } catch (error) {
      console.error("Error saving order:", error);
      setSuccessMessage("Failed to place the order. Try again.");
    }
  };
 
  const handleReset = () => {
    reset(); // Reset all form fields to their initial state
    setSuccessMessage(""); // Clear success message
  };
 
  if (!selectedItem) {
    return <div>Loading item details...</div>;
  }
  return (
    <FormContainer id="order-form">
      <Grid container spacing={3}>
        {/* Left Side - Image */}
        <Grid item xs={12} sm={6}>
          <Card
            sx={{
              marginTop: "20px",
              height: "100%",
              backgroundColor: "#EEEADE",
            }}
          >
            <CardMedia
              component="img"
              image={`../cakes/${selectedItem.image}`}
              alt={selectedItem.name}
            />
            <CardContent>
            <Typography
                variant="h6"
                style={{
                  fontWeight:"bolder", 
                  fontSize:"25px",
                  marginTop: "10px",
                  marginBottom: "10px",
                  textAlign: "left",
                }}
              >
                <b>Description:</b>
              </Typography>
              <Typography
                variant="body2"
                style={{ color: "#555", textAlign: "justify" }}
              >
                {selectedItem.description}
              </Typography>
 
              {/* Delivery Information */}
              <Typography variant="body2" style={{ marginTop: "16px", textAlign:"left" }}>
                <b style={{fontWeight:"bolder", fontSize:"25px"}}>Delivery Information:</b>
                <ul style={{marginLeft: "35px", marginTop:"10px"}}>
                  <li>
                    Every cake we offer is handcrafted, and since each chef has
                    his/her own way of baking and designing a cake, there might
                    be slight variation in the product in terms of design and
                    shape.
                  </li>
                  <li>
                    Since cakes are perishable in nature, we attempt delivery of
                    your order only once. The delivery cannot be redirected to
                    another address.
                  </li>
                  <li>
                    Store cream cakes in a refrigerator. Fondant cakes should be
                    stored in an air-conditioned environment.
                  </li>
                </ul>
              </Typography>
 
              {/* Care Instructions */}
              <Typography variant="body2" style={{ marginTop: "16px" , textAlign:"left"}}>
                <b style={{fontWeight:"bolder", fontSize:"25px"}}>Care Instructions:</b>
                <ul style={{marginLeft: "35px", marginTop:"10px"}}>
                  <li>
                    Slice and serve the cake at room temperature and make sure
                    it is not exposed to heat.
                  </li>
                  <li>Use a serrated knife to cut a fondant cake.</li>
                  <li>The cake should be consumed within 24 hours.</li>
                  <li>Enjoy Your cake</li>
                </ul>
              </Typography>
            </CardContent>
          </Card>
        </Grid>
        {/* Right Side - Form */}
        <Grid item xs={12} sm={6}>
        <FormHeader style={{ fontFamily: "cursive" }}>
            <Typography
              variant="h5"
              style={{ textAlign: "left", marginTop: "10px" }}
            >
              <b> {selectedItem.name}</b>
              <img style={{marginLeft:"10px"}} src="/cakes/rating.jpg" alt="Cake rating" /> 
              <b style={{fontSize: "15px", marginLeft:"10px"}}>{selectedItem.rating}</b> 
            </Typography>{" "}
            <Typography variant="h6" style={{ textAlign: "left" }}>
              <b>Rs {selectedItem.price}</b>
            </Typography>
          </FormHeader>

          <FormHeader style={{ fontFamily: "cursive" }}>
            <Typography
              variant="h5"
              style={{ textAlign: "left",fontSize:"14px"}}
            >
              <p>Fill Details to place the order </p>
            </Typography>
          </FormHeader>
          <form onSubmit={handleSubmit(onSubmit)}>
            {/* Customer Details */}
            <Controller
              name="firstName"
              control={control}
              defaultValue=""
              rules={{ required: "First name is required" }}
              render={({ field }) => (
                <TextField
                  {...field}
                  label="First Name"
                  error={!!errors.firstName}
                  helperText={errors.firstName?.message}
                  fullWidth
                  margin="normal"
                />
              )}
            />
            <Controller
              name="lastName"
              control={control}
              defaultValue=""
              rules={{ required: "Last name is required" }}
              render={({ field }) => (
                <TextField
                  {...field}
                  label="Last Name"
                  error={!!errors.lastName}
                  helperText={errors.lastName?.message}
                  fullWidth
                  margin="normal"
                />
              )}
            />
            <Controller
              name="email"
              control={control}
              defaultValue=""
              rules={{
                required: "Email is required",
                pattern: {
                  value: /^\S+@\S+\.\S+$/,
                  message: "Invalid email address",
                },
              }}
              render={({ field }) => (
                <TextField
                  {...field}
                  label="Email"
                  error={!!errors.email}
                  helperText={errors.email?.message}
                  fullWidth
                  margin="normal"
                />
              )}
            />
            <Controller
              name="phone"
              control={control}
              defaultValue=""
              rules={{
                required: "Phone number is required",
                pattern: {
                  value: /^[789]\d{9}$/,
                  message: "Invalid phone number",
                },
              }}
              render={({ field }) => (
                <TextField
                  {...field}
                  label="Phone"
                  error={!!errors.phone}
                  helperText={errors.phone?.message}
                  fullWidth
                  margin="normal"
                />
              )}
            />
 
            {/* Order Details */}
            <Controller
              name="deliveryDate"
              control={control}
              defaultValue=""
              rules={{
                required: "Delivery date is required",
                validate: (value) =>
                  new Date(value) >= new Date() ||
                  "Delivery date must be today or later",
              }}
              render={({ field }) => (
                <TextField
                  {...field}
                  label="Delivery Date"
                  type="date"
                  InputLabelProps={{ shrink: true }}
                  error={!!errors.deliveryDate}
                  helperText={errors.deliveryDate?.message}
                  fullWidth
                  margin="normal"
                />
              )}
            />
            <Controller
              name="quantity"
              control={control}
              defaultValue=""
              rules={{
                required: "Quantity is required",
                min: { value: 1, message: "Minimum quantity is 1" },
                max: { value: 20, message: "Maximum quantity is 20" },
              }}
              render={({ field }) => (
                <TextField
                  {...field}
                  label="Quantity"
                  type="number"
                  error={!!errors.quantity}
                  helperText={errors.quantity?.message}
                  fullWidth
                  margin="normal"
                />
              )}
            />
            <Controller
              name="weight"
              control={control}
              defaultValue=""
              rules={{ required: "Weight/Pieces is required" }}
              render={({ field }) => (
                <TextField
                  {...field}
                  select
                  label="Weight/Pieces"
                  error={!!errors.weight}
                  helperText={errors.weight?.message}
                  fullWidth
                  margin="normal"
                >
                  {weights.map((option) => (
                    <MenuItem key={option} value={option}>
                      {option}
                    </MenuItem>
                  ))}
                </TextField>
              )}
            />
 
            {/* Address Details */}
            <Controller
              name="address"
              control={control}
              defaultValue=""
              rules={{ required: "Address is required" }}
              render={({ field }) => (
                <TextField
                  {...field}
                  label="Address"
                  error={!!errors.address}
                  helperText={errors.address?.message}
                  fullWidth
                  margin="normal"
                />
              )}
            />
            <Controller
              name="city"
              control={control}
              defaultValue=""
              rules={{ required: "City is required" }}
              render={({ field }) => (
                <TextField
                  {...field}
                  label="City"
                  error={!!errors.city}
                  helperText={errors.city?.message}
                  fullWidth
                  margin="normal"
                />
              )}
            />
            <Controller
              name="state"
              control={control}
              defaultValue=""
              rules={{ required: "State is required" }}
              render={({ field }) => (
                <TextField
                  {...field}
                  label="State"
                  error={!!errors.state}
                  helperText={errors.state?.message}
                  fullWidth
                  margin="normal"
                />
              )}
            />
            <Controller
              name="zipCode"
              control={control}
              defaultValue=""
              rules={{
                required: "Zip code is required",
                pattern: {
                  value: /^\d{6}$/,
                  message: "Zip code must be 6 digits",
                },
              }}
              render={({ field }) => (
                <TextField
                  {...field}
                  label="Zip Code"
                  error={!!errors.zipCode}
                  helperText={errors.zipCode?.message}
                  fullWidth
                  margin="normal"
                />
              )}
            />
 
            <Button
              type="submit"
              variant="contained"
              color="primary"
              disabled={!isValid}
            >
              Submit
            </Button>
            <Button
              type="button"
              variant="contained"
              color="warning"
              onClick={handleReset}
              style={{ marginLeft: "10px" }}
            >
              Reset
            </Button>
          </form>
        </Grid>
      </Grid>
      {/* Snackbar for success message */}
      <Snackbar open={!!successMessage} autoHideDuration={4000}>
        <Alert severity="success">{successMessage}</Alert>
      </Snackbar>
    </FormContainer>
  );
};
 
export default OrderForm;