import React from "react";
import Header from "../components/Header";
import Footer from "../components/Footer";
import styled from "styled-components";

const Wrapper = styled.div`
  // min-height: 60vh;
  font-family: var(--primary-font);

  .banner {
    width: 100vw;
    height: 90vh;

    .cover {
      width: 100vw;
      height: 90vh;
      color: black;
      opacity: 0.4;
    }
  }
`;

function Home() {
  return (
    <>
      <Header />

      <Wrapper>
        <section className="banner z-50 relative flex flex-col justify-center items-center">
          <div className="w-[50vw] z-10 text-center">
            <p className="text-2xl lg:text-6xl font-bold z-10 py-5">
              ArinPay Wallet
            </p>
            <p className="text-gray-300 text-xl z-10 lg:text-4xl">
              Payment made Easy
            </p>
          </div>
          <div className="cover absolute top-0 right-0 left-0"></div>
          <div className="fadout"></div>
        </section>
      </Wrapper>

      <Footer />
    </>
  );
}

export default Home;
