import { default as axios } from 'axios';
import * as cheerio from 'cheerio';

//Sample code - Web scraping
interface Link {
  title: string;
  href: string;
  date: string;
  imgSrc: string;
}

axios.get('https://iuyouth.edu.vn/iu-youth-voice/')
  .then((response) => {
    const $ = cheerio.load(response.data);
    const content = $('.jeg_main_content').html();
    // render the content in a modal or a separate page
    console.log(content);
  })

axios
  .get("https://iuyouth.edu.vn")
  .then((response) => {
    const $ = cheerio.load(response.data);

    // Thông tin quan trọng
    const linkObjects1: Link[] = [];
    $(".jeg_postblock_3 .jeg_postblock_content").each((i, element) => {
      const postElement = $(element).find(".jeg_post_title");
      const title = postElement.find("a").text();
      const href = postElement.find("a").attr("href") || "";
      const date = $(element).find(".jeg_meta_date a").text();
      const imgSrc = $(".jeg_thumb a img.wp-post-image").attr("data-src") || "";
      linkObjects1.push({ title, href, date, imgSrc });
    });
    console.log("Thông tin quan trọng: ", linkObjects1.slice(0, 4));

    // Tin tức Đoàn
    const linkObjects2: Link[] = [];
    $(".jeg_postblock_3 .jeg_postblock_content").each((i, element) => {
      const postElement = $(element).find(".jeg_post_title");
      const title = postElement.find("a").text();
      const href = postElement.find("a").attr("href") || "";
      const date = $(element).find(".jeg_meta_date a").text();
      const imgSrc = $(".jeg_thumb a img.wp-post-image").attr("data-src") || "";
      linkObjects2.push({ title, href, date, imgSrc });
    });
    console.log("\nTin tức Đoàn: ", linkObjects2.slice(4, 8));

    // Tin tức Hội
    const linkObjects3: Link[] = [];
    $(".jeg_postblock_3 .jeg_postblock_content").each((i, element) => {
      const postElement = $(element).find(".jeg_post_title");
      const title = postElement.find("a").text();
      const href = postElement.find("a").attr("href") || "";
      const date = $(element).find(".jeg_meta_date a").text();
      const imgSrc = $(".jeg_thumb a img.wp-post-image").attr("data-src") || "";
      linkObjects3.push({ title, href, date, imgSrc });
    });
    console.log("\nTin tức Hội: ", linkObjects3.slice(8, 12));

    // Tin tức
    const linkObjects4: Link[] = [];
    $(".jeg_postblock_3 .jeg_postblock_content").each((i, element) => {
      const postElement = $(element).find(".jeg_post_title");
      const title = postElement.find("a").text();
      const href = postElement.find("a").attr("href") || "";
      const date = $(element).find(".jeg_meta_date a").text();
      const imgSrc = $(".jeg_thumb a img.wp-post-image").attr("data-src") || "";
      linkObjects4.push({ title, href, date, imgSrc });
    });
    console.log("\nTin tức: ", linkObjects4.slice(12, 16));

    // Thông báo IU
    const linkObjects5: Link[] = [];
    $(".jeg_postblock_3 .jeg_postblock_content").each((i, element) => {
      const postElement = $(element).find(".jeg_post_title");
      const title = postElement.find("a").text();
      const href = postElement.find("a").attr("href") || "";
      const date = $(element).find(".jeg_meta_date a").text();
      const imgSrc = $(".jeg_thumb a img.wp-post-image").attr("data-src") || "";
      linkObjects5.push({ title, href, date, imgSrc });
    });
    console.log("\nThông báo IU: ", linkObjects5.slice(16, 20));
})

