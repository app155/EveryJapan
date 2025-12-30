// Type definitions for the application

export interface UserProfile {
  id: number;
  username: string;
  email: string;
  nickname?: string;
  avatar?: string;
  postCount?: number;
  commentCount?: number;
  joinDate?: string;
}

export interface Post {
  id: number;
  title: string;
  content: string;
  author: string;
  authorId: number;
  createdAt: string;
  viewCount: number;
  commentCount: number;
  likeCount: number;
  boardId: number;
  boardName?: string;
}

export interface HotPost {
  id: number;
  title: string;
  author: string;
  viewCount: number;
  commentCount: number;
  likeCount: number;
  createdAt: string;
  isHot: boolean;
}

export interface Board {
  id: number;
  name: string;
  description?: string;
  postCount: number;
  category?: string;
  icon?: string;
}
