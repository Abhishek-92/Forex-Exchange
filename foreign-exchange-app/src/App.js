import { useState } from "react";
import { Button, Form } from "react-bootstrap";
import axios from "axios";
import './App.css'

function App() {

  const [data, setData] = useState({});
  const [currRes, setCurrRes] = useState(0);

  const inputHandler = (event) => {
    setData(() => ({
      ...data, [event.target.name]: event.target.value
    }))
  }

  const submitHandler = (event) => {
    event.preventDefault();
    axios.get('http://localhost:8085/api2/currConvert', {
      params: data
    })
      .then(response => {

        setCurrRes(Number(response.data).toFixed(2));
      })
      .catch(error => {
        console.log(error.message);
      });
    // console.log(typeof data.curr);
    // console.log(typeof data.fromCurr);
    // console.log(typeof data.toCurr);
  }

  return (
    <div className="app ">
      <div className="mx-auto col-8 text-center border border-success p-2 mb-2 border-opacity-25 mar rounded-5">
        <Form onSubmit={submitHandler}>
          <div className="d-flex justify-content-around">
            <div className="m-3">
              <Form.Label htmlFor="curr" >
                Enter Value
              </Form.Label>
              <Form.Control
                className="mb-2"
                id="curr"
                placeholder="0.0"
                name="curr"
                type="number"
                step="0.01"
                onChange={inputHandler}
                required
              />
            </div>

            <div className="m-3">
              <Form.Label htmlFor="fromCurr" >
                From
              </Form.Label>
              <Form.Control
                className="mb-2"
                id="fromCurr"
                placeholder="USD"
                name="fromCurr"
                onChange={inputHandler}
                required
              />
            </div>

            <div className="m-3">
              <Form.Label htmlFor="toCurr" >
                To
              </Form.Label>
              <Form.Control
                className="mb-2"
                id="toCurr"
                placeholder="INR"
                name="toCurr"
                onChange={inputHandler}
                required
              />
            </div>
          </div>
          <div>
            <div style={{ display: currRes ? 'inline-block' : 'none' }} className="fs-1">
              {currRes}
            </div>
          </div>
          <div className="d-flex justify-content-center mt-4">
            <Button type="submit" className="mb-2">
              Submit
            </Button>
          </div>
        </Form>
      </div>
    </div>
  );
}

export default App;
