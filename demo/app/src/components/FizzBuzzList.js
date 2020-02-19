import React, { Component } from 'react';
import { Row, Col } from 'reactstrap';
// eslint-disable-next-line
import styles from '../style/fizzBuzz.css';
import cn from "classnames";

class FizzBuzzList extends Component {

  state = {
    Show: false
  }

  constructor(props) {
    super(props);
    this.state = {isLoading: true};
  }

  componentDidMount() {
    fetch('api/allFizzBuzzItems')
      .then(response => response.json())
      .then(data => {
          this.setState({allFizzBuzzItems: data, isLoading: false, shouldUpdate: false});
      });
  }

  componentDidUpdate(prevProps, nextProps) {
    if (!this.props.data.shouldUpdateFizzBuzz) {
        return;
    }

    const customHeaders = new Headers();
    customHeaders.append('pragma', 'no-cache');
    customHeaders.append('cache-control', 'no-cache');

    const customInit = {
        method: 'GET',
        headers: customHeaders,
    }

    fetch('api/allFizzBuzzItems', customInit)
      .then(response => response.json())
      .then(data => {
          this.setState({allFizzBuzzItems: data, isLoading: false});
          return;
      })
      .then(() => {
        this.props.data.shouldUpdateFizzBuzz= false;
      });
  }

  render() {
    const {allFizzBuzzItems, isLoading} = this.state;

    if (isLoading) {
      return <p>Laden...</p>;
    }

    const groupList = allFizzBuzzItems.map((group, idx) => {
      const isDataSetNew = Number(this.props.data.fizzBuzzInputValue) === group.input;

      const rowClassName = cn(
        idx % 2 === 0 ? "table_row___primary" : "table_row___secondary",
        isDataSetNew ? "table_row___highlight" : ""
      );

      return (<Row className={rowClassName} key={idx} data-testid="fizzbuzz-row">
            <Col lg={3} sm={3} xs={3} data-testid="fizzbuzz-display-input-value">{group.input}</Col>
            <Col lg={3} sm={3} xs={3}>{group.value}</Col>
            <Col lg={6} sm={6} xs={6} className="text___rightAlign">{group.timestamp}</Col>
          </Row>);
    });
    if (!groupList.length) {
        return (
          <div className="table" key="-1">
            <Row className="table_header">
                <Col>
                    <div className="text___center">Keine Daten vorhanden</div>
                </Col>
            </Row>
            {groupList}
          </div>
        );
    }
    return (
      <div className="table" key="-1">
        <Row className="table_header text___fat">
          <Col lg={3} sm={3} xs={3}>Eingabe</Col>
          <Col lg={3} sm={3} xs={3}>Wert</Col>
          <Col lg={6} sm={6} xs={6} className="text___rightAlign">Timestamp</Col>
        </Row>
        {groupList}
      </div>
    );
  }
}

export default FizzBuzzList;