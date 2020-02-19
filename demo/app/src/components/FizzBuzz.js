import React, { Component } from 'react';
import { Container, Row, Col, } from 'reactstrap';
import FizzBuzzList from './FizzBuzzList';

class FizzBuzz extends Component {

  constructor(props) {
    super(props);
    this.state = {
        fizzBuzzInputValue: null,
        errors: ""
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleCancel = this.handleCancel.bind(this);
  }

  handleChange(event) {
    const target = event.target;
    const fizzBuzzInputValue = target.value;
    this.setState({errors: fizzBuzzInputValue <= 0 ? "Bitte nur natürliche Zahlen beginnend bei 1 eingeben" : ""});
  }

  handleCancel(event) {
    this.refs.fizzBuzzInputField.value = "";
  }


  async handleSubmit(event) {
    if (this.refs.fizzBuzzInputField.value === "") {
        return;
    }
    const input = this.refs.fizzBuzzInputField.value;

    this.setState({fizzBuzzInputValue: input});
    event.preventDefault();
    await fetch('/api/fizzbuzz', {
      method: 'PUT',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({value: input}),
    });
    this.setState({shouldUpdateFizzBuzz: true});
    this.refs.fizzBuzzInputField.value = "";
  }

  render() {
    return <div>
      <Container className="fizzBuzzContainer">
        <div className="text___center text___big text___fat">Fizz Buzz</div>
        <form onSubmit={this.handleSubmit}>
          <Row>
            <Col lg={6} sm={6} xs={12}>
                <input type="number"
                   className="fizzBuzzInput"
                   placeholder="Bitte eine natürliche Zahl eingeben"
                   ref="fizzBuzzInputField"
                   name="fizzbuzz"
                   id="fizzbuzzInput"
                   data-testid="fizzbuzz-input"
                   onChange={this.handleChange} />
                   {this.state.errors && <span className='text___error' data-testid="fizzbuzz-error">{this.state.errors}</span>}
            </Col>
            <Col lg={3} sm={3} xs={6}>
                <input type="button"
                    value="Abbrechen"
                    className="button button_cancel"
                    data-testid="fizzbuzz-button-cancel"
                    onClick={this.handleCancel}/>
            </Col>
            <Col lg={3} sm={3} xs={6}>
                <input type="submit"
                    value="Speichern"
                    className="button button_save"
                    data-testid="fizzbuzz-button-submit" />
            </Col>
          </Row>
          <Row>
            <Col>
              <FizzBuzzList data={ this.state } />
            </Col>
          </Row>
        </form>
      </Container>
    </div>
  }
}

export default FizzBuzz;